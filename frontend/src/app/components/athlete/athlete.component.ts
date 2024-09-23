import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { AthleteService } from '../../services/athlete.service';
import { UtilService } from '../../services/util.service';
import { switchMap } from 'rxjs/operators';

@Component({
  selector: 'app-athlete',
  templateUrl: './athlete.component.html',
})
export class AthleteComponent implements OnInit {
  athlete: any;
  athleteUserId: any;
  team: any;
  teamId: any;
  teams: any;
  teamMembers: any;

  constructor(
    private route: ActivatedRoute,
    private athleteService: AthleteService,
    public utilService: UtilService
  ) {}

  ngOnInit(): void {
    this.route.paramMap.pipe(
      switchMap(params => {
        const id = params.get('id');
        this.athleteUserId = id;
  
        if (id) {
          const idNumber = +id; // Convert id to number
          return this.athleteService.getAthleteById(idNumber).pipe(
            switchMap(athleteData => {
              this.athlete = athleteData;
              return this.athleteService.getTeamNameByUserId(idNumber);
            }),
            switchMap(teamData => {
              this.team = teamData;
  
              // Only attempt to get team members if team is not null
              if (this.team && this.team.id) {
                this.teamId = this.team.id;
                this.getTeamMembersOfTeamId();
              }
  
              return this.athleteService.getAllTeams();
            })
          );
        } else {
          return [];
        }
      })
    ).subscribe(data => {
      this.teams = data; // All teams will be updated here
    });
  }
  

  // Method to get athlete by id (can be used elsewhere)
  getById(id: number) {
    this.athleteService.getAthleteById(id).subscribe(data => {
      this.athlete = data;
    });
  }

  // Method to add the team member to a team
  addTeamMember(teamId: number) {
    this.athleteService.addTeamMember(teamId, this.athleteUserId).subscribe(data => {
      console.log("New athlete was added to team ", teamId);
    });
  }

  // Method to get team members of the current team
  getTeamMembersOfTeamId() {
    console.log(this.teamId);
    this.athleteService.getTeamMembersOfTeamId(this.teamId).subscribe(data => {
      this.teamMembers = data;
    });
  }

  // Method to get flag color
  getFlagColor(flag: string): string {
    switch (flag) {
      case 'blue':
        return 'blue';
      case 'green':
        return 'green';
      case 'red':
        return 'red';
      case 'orange':
        return 'orange';
      default:
        return '';
    }
  }
}
