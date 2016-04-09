// adicionado o AppModule para 'herdar' a lista de clientes
angular.module('ClienteModule', ['AppModule']).

controller('ClienteController', ['$scope', function($scope){
	
	$scope.cliente = {};
	$scope.pesquisa = '';
	$scope.editarRegistro = false;

	$scope.editar = function (obj) {
		$scope.editarRegistro = true;
		$scope.cliente = angular.copy(obj);
	};

	$scope.excluir = function (key) {
		for (var i = 0; i < $scope.listaCliente.length; i++) {
			if($scope.listaCliente[i].id==key) {
				$scope.listaCliente.splice(i, 1);
				$scope.pesquisa = '';
			}
		}		
	};

	$scope.salvarEdicao = function () {
		if(!$scope.cliente.nome || !$scope.cliente.email) {
			alert('Campos obrigatórios não foram preenchidos!');
			return;
		}

		$scope.excluir($scope.cliente.id);

		$scope.cliente.id = $scope.getFakeID();
		$scope.listaCliente.push($scope.cliente);
		$scope.editarRegistro = false;	
	};

	$scope.cancelarEdicao = function () {
		$scope.editarRegistro = false;	
	};

	$scope.salvar = function () {
		if(!$scope.cliente.nome || !$scope.cliente.email) {
			alert('Campos obrigatórios não foram preenchidos!');
			return;
		}

		$scope.cliente.id = $scope.getFakeID();
		$scope.listaCliente.push($scope.cliente);
		$scope.redir('/cliente-lista');
	};

}]);