angular.module('livroApp', [])
  .controller('LivroListController', function ($http) {
    var livroList = this;
    livroList.livros = [];
    livroList.totalRegistros = 0;

    livroList.buscar = function () {
      console.log(livroList.filtro);
      var params = {
        filtro: livroList.filtro,
        anoInicial: livroList.anoInicial,
        anoFinal: livroList.anoFinal
      }
      $http.get('http://localhost:8080/livrosServer/livros', {params}).then(function (response) {
        console.log(response);
        livroList.livros = response.data.registros;
        livroList.totalRegistros = response.data.totalRegistros;
      });
    };



    /*todoList.todos = [
      {text:'learn AngularJS', done:true},
      {text:'build an AngularJS app', done:false}];
 
    todoList.addTodo = function() {
      todoList.todos.push({text:todoList.todoText, done:false});
      todoList.todoText = '';
    };
 
    todoList.remaining = function() {
      var count = 0;
      angular.forEach(todoList.todos, function(todo) {
        count += todo.done ? 0 : 1;
      });
      return count;
    };
 
    todoList.archive = function() {
      var oldTodos = todoList.todos;
      todoList.todos = [];
      angular.forEach(oldTodos, function(todo) {
        if (!todo.done) todoList.todos.push(todo);
      });
    };*/
  });