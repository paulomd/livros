angular.module('livroApp', [])
  .controller('LivroListController', function ($http) {
    var livroList = this;
    livroList.livros = [];
    livroList.totalRegistros = 0;
    livroList.registrosPorPagina = 10;

    livroList.clickBuscar = function () {
      var params = {
        filtro: livroList.filtro,
        anoInicial: livroList.anoInicial,
        anoFinal: livroList.anoFinal,
        registrosPorPagina: livroList.registrosPorPagina
      }
      livroList.buscar(params)
    }

    livroList.clickPagina = function (pagina) {
      var params = livroList.filtroExecutado;
      params.pagina = pagina;
      livroList.buscar(params)
    }

    livroList.clickDetalhe = function (livro) {
      livroList.livroDetalhe = livro;
    }

    livroList.buscar = function (params) {
      livroList.filtroExecutado = params;
      $http.get('http://localhost:8080/livrosServer/livros', {params}).then(function (response) {
        console.log(response);
        livroList.livros = response.data.registros;
        livroList.totalRegistros = response.data.totalRegistros;
        livroList.paginas = response.data.paginas;
      });
    };
  });