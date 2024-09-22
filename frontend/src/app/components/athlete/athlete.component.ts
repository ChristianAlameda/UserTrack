import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { AthleteService } from '../../services/athlete.service';
import { UtilService } from '../../services/util.service';

@Component({
  selector: 'app-athlete',
  templateUrl: './athlete.component.html',
})
export class AthleteComponent implements OnInit{
  athlete: any;
  athleteUserId:any;
  team: any;
  teamId: any;
  teams: any;
  teamMembers: any;
  
  constructor(
    private route: ActivatedRoute,
    private athleteService: AthleteService,
    public utilService: UtilService
  ) { }

  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id');
    this.athleteUserId = id;
    if (id) {
      // Convert id to number
      const idNumber = +id; // or use parseInt(id, 10)
      this.athleteService.getAthleteById(idNumber).subscribe(data => {
        this.athlete = data;
      });

      this.athleteService.getTeamNameByUserId(idNumber).subscribe(data => {
        this.team = data;
        this.teamId = this.team['id'];
        // Now that the team is defined, call the method to get team members
        if (this.teamId) {
          this.getTeamMembersOfTeamId();
        }
      });

      this.athleteService.getAllTeams().subscribe(data => {
        this.teams = data;
      });
    }
    
  }  

  getById(id: number){
    this.athleteService.getAthleteById(id).subscribe(data => {
      this.athlete = data;
    });
  }

  // add the team member to a team
  addTeamMember(teamId: number){
    this.athleteService.addTeamMember(teamId, this.athleteUserId).subscribe(data => {
      console.log("New athlete was added to team ", teamId)
    });
  }

  getTeamMembersOfTeamId(){
    console.log(this.teamId);
    this.athleteService.getTeamMembersOfTeamId(this.teamId).subscribe(data => {
      this.teamMembers = data;
    });
  }
}
