import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Todo } from './todo';
import { HttpClient } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class TodoService {

  apiURL: string = 'http://localhost:8080/api/todos';

  constructor(
    private http: HttpClient
  ) { }

  salvar(todo: Todo): Observable<Todo>{
    return this.http.post<Todo>(this.apiURL,todo);
  }

  listar():Observable<Todo[]>{
    return this.http.get<Todo[]>(this.apiURL);
  }
}