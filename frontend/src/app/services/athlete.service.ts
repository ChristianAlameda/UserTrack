import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../models/user.model';
import { UserStudent } from '../models/userStudent.model';
import { UserAthlete } from '../models/userAthlete.model';
import { UserStudentAthlete } from '../models/userStudentAthlete.model';
import { Student } from '../models/student.model';
import { Athlete } from '../models/athlete.model';
import { Team } from '../models/team.model';
import { TeamMember } from '../models/teamMember.model';

@Injectable({
  providedIn: 'root'
})
export class AthleteService {
    private athleteUrl = 'http://localhost:8080/api/athletes';

    constructor(private http: HttpClient) {}
    // unused
    getAllAthletes(): Observable<Athlete[]> {
        return this.http.get<Athlete[]>(`${this.athleteUrl}`);
    }
    // used
    getAthleteById(id: number): Observable<Athlete> {
      return this.http.get<Athlete>(`${this.athleteUrl}/${id}`);
    }

    private teamUrl = "http://localhost:8080/api/teams";
    // used
    getTeamNameByUserId(userId: number): Observable<Team> {
      return this.http.get<Team>(`${this.teamUrl}/${userId}`);
    }

    getAllTeams(): Observable<Team[]> {
      return this.http.get<Team[]>(`${this.teamUrl}`);
    }

    private teamMemberUrl = "http://localhost:8080/api/teamMembers";
    // Used 
    getTeamMembersOfTeamId(teamId: number): Observable<UserAthlete[]>{
      return this.http.get<UserAthlete[]>(`${this.teamMemberUrl}/${teamId}`)
    }

    //used
    addTeamMember(teamId: number, userId: number): Observable<TeamMember>{
      return this.http.get<TeamMember>(`${this.teamMemberUrl}/${teamId}/${userId}`)
    }

}