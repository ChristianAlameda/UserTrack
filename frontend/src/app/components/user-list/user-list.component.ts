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
  styleUrls: ['./user-list.component.scss'],
})
export class AppUserListComponent implements OnInit {
  allUsers: User[] = []; 
  filteredUsers: User[] = []; 
  user: User | null = null;
  count: number = 0;
  lastName: string = '';
  searchResults: User[] = [];
  // For deciding what user to select for All section
  AllOfWhich: string[] = ['User', 'Student', 'Athlete'];  
  AllOfWhichValue: string = 'User';
  // deciding what type of user we are adding
  userTypes: string[] = ['User', 'UserStudent', 'UserAthlete', 'UserStudentAthlete'];  
  inputValue: string = 'User';
  // deciding whether to get by email or date
  emailOrDates: string[] = ['Email', 'Date'];  
  emailOrDateValue: string = 'Email';

  // Student
  allStudents: Student[] = []; 
  studentCount: number = 0;

  // Athlete
  allAthletes: Athlete[] = [];
  athleteCount: number = 0;
  
  constructor(
    private userService: UserService, 
    private studentService: StudentService, 
    private athleteService: AthleteService ) {}

  ngOnInit(): void {
    this.getAllUsers();
    this.getAllStudents();
    this.getAllAthletes()
  }

  getAllAthletes(): void {
    this.athleteService.getAllAthletes().subscribe(data=>{
      console.log(data);
      this.allAthletes = data;
      this.athleteCount = data.length;
    })
  }

  getAllStudents(): void {
    this.studentService.getAllStudents().subscribe(data=>{
      this.allStudents = data;
      this.studentCount = data.length;
    })
  }

  getAllUsers(): void {
    this.userService.getAllUsers().subscribe(data => {
      this.allUsers = data;
      this.count = data.length;
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
      this.count = data;
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

  getUserByFirstName(firstName: string): void {
    this.userService.getUserByFirstName(firstName).subscribe(data => {
      this.searchResults = data;
    });
  }
}
