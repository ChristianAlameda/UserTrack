import { Component, OnInit } from '@angular/core';
import { User } from '../../models/user.model';
import { UserService } from '../../services/user.service';
import { UserStudent } from '../../models/userStudent.model';
import { UserAthlete } from '../../models/userAthlete.model';
import { UserStudentAthlete } from '../../models/userStudentAthlete.model';
import { StudentService } from '../../services/student.service';
import { Student } from '../../models/student.model';
import { Athlete } from '../../models/athlete.model';
import { AthleteService } from '../../services/athlete.service';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
})
export class AppUserListComponent implements OnInit {
  allUsers: User[] = []; 
  filteredUsers: User[] = []; 
  user: User | null = null;
  userCount: number = 0;
  lastName: string = '';
  searchResults: User[] = [];
  // For deciding what user to select for All section
  AllOfWhich: string[] = ['User', 'Student', 'Athlete'];  
  AllOfWhichValue: string = '';
  // deciding whether to get by email or date
  emailOrDates: string[] = ['Name','Email', 'Date', ];  
  emailOrDateValue: string = '';
  // deciding what type of user we are adding
  userTypes: string[] = ['User', 'UserStudent', 'UserAthlete', 'UserStudentAthlete'];  
  inputValue: string = '';
  

  // Student
  allStudents: UserStudent[] = []; 
  studentCount: number = 0;

  // Athlete
  allAthletes: UserAthlete[] = [];
  athleteCount: number = 0;

  // student athletes
  allStudentAthletes: UserStudentAthlete[] = [];
  allStudentAthletesCount: number = 0;

  
  constructor(
    private userService: UserService, 
     ) {}

  ngOnInit(): void {
    this.getAllUsers();
    this.getAllStudents();
    this.getAllAthletes()
    // this.getAllStudentAthletes()

  }

  getAllAthletes(): void {
    this.userService.getAllAthletes().subscribe(data=>{
      console.log(data);
      this.allAthletes = data;
      this.athleteCount = data.length;
    })
  }

  getAllStudents(): void {
    this.userService.getAllStudents().subscribe(data=>{
      this.allStudents = data;
      this.studentCount = data.length;
    })
  }

  // getAllStudentAthletes(): void {
  //   this.userService.getAllStudentAthletes().subscribe(data=>{
  //     this.allStudentAthletes = data;
  //     this.allStudentAthletesCount = data.length;
  //   })
  // }

  getAllUsers(): void {
    this.userService.getAllUsers().subscribe(data => {
      this.allUsers = data;
      this.userCount = data.length;
    });
  }

  getUserByEmail(email: string): void {
    this.userService.getUserByEmail(email).subscribe(data => {
      this.filteredUsers = data;
    });
  }

  getUsersByDate(date: string): void {
    this.userService.getUsersByDate(date).subscribe(data => {
      this.filteredUsers = data;
    });
  }

  getCountByLastName(lastName: string): void {
    this.userService.getCountOfLastName(lastName).subscribe(data => {
      this.userCount = data;
      this.lastName = lastName;
    });
  }

  // Add user
  addUser(firstName: string, lastName: string, email: string) {
    const newUser: User = {
      firstName: firstName,
      lastName: lastName,
      email: email,
      flag: 'blue',
    };

    this.userService.addUser(newUser).subscribe(response => {
      console.log('User added:', response);
      this.getAllUsers();  // Refresh users after adding
    });
  }

  // Add user and athlete
  addUserAthlete(
    firstName: string, 
    lastName: string, 
    email: string, 
    speed: number, 
    height: number, 
    weight: number, 
    starRating: number, 
    athleteSchedule: string
  ) {
    const newUserAthlete: UserAthlete = {
      // user
      firstName: firstName,
      lastName: lastName,
      email: email,
      flag: 'green',
      // athlete
      speed: speed,
      height: height,
      weight: weight,
      starRating: starRating,
      athleteSchedule: athleteSchedule,
    };
    console.log('newUserAthlete', newUserAthlete, 1);

    this.userService.addUserAthlete(newUserAthlete).subscribe(response => {
      console.log('User and Athlete added:', response);
      this.getAllUsers();  // Refresh users after adding
    });
  }

  // Add a new user and student
  addUserStudent(
    firstName: string, 
    lastName: string, 
    email: string, 
    className: string, 
    grade: string, 
    studentSchedule: string
  ): void {
    const newUserStudent: UserStudent = {
      // User
      firstName: firstName,
      lastName: lastName,
      email: email,
      flag: 'red',
      // Student
      className: className,
      grade: grade,
      studentSchedule: studentSchedule
    }; 
    console.log(newUserStudent);

    this.userService.addUserStudent(newUserStudent).subscribe(response => {
      console.log('User and Student added:', response);
      this.getAllUsers();  // Refresh users after adding
    });
  }

  // Add a new user, student, and athlete
  addUserStudentAthlete(
    firstName: string, 
    lastName: string, 
    email: string,
    className: string, 
    grade: string, 
    studentSchedule: string,
    speed: number, 
    height: number, 
    weight: number, 
    starRating: number, 
    athleteSchedule: string
  ) {
    const newUserStudentAthlete: UserStudentAthlete = {
      // User
      firstName: firstName,
      lastName: lastName,
      email: email,
      flag: 'orange',
      // Student
      className: className, 
      grade: grade,
      studentSchedule: studentSchedule,
      // Athlete
      speed: speed,
      height: height,
      weight: weight,
      starRating: starRating,
      athleteSchedule: athleteSchedule,
    };

    console.log('xx');

    this.userService.addUserStudentAthlete(newUserStudentAthlete).subscribe(response => {
      console.log('User and Athlete added:', response);
      this.getAllUsers();  // Refresh users after adding
    });
  }

  deleteUser(id: number): void {
    this.userService.deleteUser(id).subscribe(() => {
      console.log(`User with ID ${id} has been deleted.`);
      this.getAllUsers(); 
    });
  }

  getUserByFirstName(firstName: string, number:number): void {
    this.userService.getUserByFirstName(firstName).subscribe(data => {
      if (number === 1){ this.filteredUsers = data;}
      else if(number === 2){ this.searchResults = data;}
    });
  }

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
