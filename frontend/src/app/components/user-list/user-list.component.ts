import { Component, OnInit } from '@angular/core';
import { User } from '../../user.model';
import { UserService } from '../../services/user.service';
import { userStudent } from '../../userStudent.model';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.scss']
})
export class AppUserListComponent implements OnInit {
  allUsers: User[] = []; 
  filteredUsers: User[] = []; 
  user: User | null = null;
  count: number = 0;
  lastName: string = '';
  searchResults: User[] = [];

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
      this.user = data;
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

  // Add a new user and student
  addUserAndStudent(firstName: string, lastName: string, email: string, className: string, grade: string, schedule: string): void {
    const newUserStudent: userStudent = {
      firstName: firstName,
      lastName: lastName,
      email: email,
      className: className,
      grade: grade,
      schedule: schedule
    };

    this.userService.addUserAndStudent(newUserStudent).subscribe(response => {
      console.log('User and Student added:', response);
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
