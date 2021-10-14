import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { User } from './user';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserServiceService {

  private usersUrl: string;

  constructor(private http: HttpClient) {
    this.usersUrl = 'http://localhost:8080/users';
  }

  public findAll(): Observable<User[]> {
    const headers= new HttpHeaders()
      .set('UNICA-ServiceId', '550e8400-e29b-41d4-a716-446655440000')
      .set('UNICA-Application', 'genesis')
      .set('UNICA-PID', '550e8400-e29b-41d4-a716-446655440000')
      .set('UNICA-User', 'arnoldo')
      .set('Access-Control-Allow-Origin', '*');
    return this.http.get<User[]>(this.usersUrl, { 'headers': headers });
  }

  public save(user: User) {
    const headers= new HttpHeaders()
      .set('UNICA-ServiceId', '550e8400-e29b-41d4-a716-446655440000')
      .set('UNICA-Application', 'genesis')
      .set('UNICA-PID', '550e8400-e29b-41d4-a716-446655440000')
      .set('UNICA-User', 'arnoldo')
      .set('Access-Control-Allow-Origin', '*');
    return this.http.post<User>(this.usersUrl, user, { 'headers': headers });
  }
}
