import { Component, OnInit } from '@angular/core';
import { User } from '../../models/user.model';
import { UserService } from '../../services/user.service';
import { UserStudent } from '../../models/userStudent.model';
import { UserAthlete } from '../../models/userAthlete.model';
import { UserStudentAthlete } from '../../models/userStudentAthlete.model';

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
  userTypes: string[] = ['User', 'UserStudent', 'UserAthlete', 'UserStudentAthlete'];  
  inputValue: string = 'User';
  emailOrDates: string[] = ['Email', 'Date'];  
  emailOrDateValue: string = 'Email';

  constructor(private userService: UserService) {}

  ngOnInit(): void {
    this.getAllUsers();
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
      firstName: firstName,
      lastName: lastName,
      email: email,
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
      firstName: firstName,
      lastName: lastName,
      email: email,
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
