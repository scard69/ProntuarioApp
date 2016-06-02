var app = angular.module('PacienteModule', []);
app.controller('PacienteController', function ($scope, $http, $location) {

                $scope.urlAtual = $location.absUrl();
                $scope.pesquisa = '';
                $scope.editarRegistro = false;
                
                $scope.salvar = function () {
                    console.log($scope.fields);
                    $http({
                        method: 'POST',
                        data: $scope.fields,
                        url: $scope.urlAtual + 'rest/pacientes',
                        headers: {'Content-Type': 'application/json'}
                    }).success(function (data, status, headers, config) {
                        console.log(data);
                        $scope.todos();
                    }).error(function (data, status, headers, config) {
                        console.log(data);
                        $scope.todos();
                    });
                };
                
                $scope.todos = function() {
                    $http.get($scope.urlAtual + 'rest/pacientes').success(function (data) {
                        $scope.pacientes = data;
                        $scope.existemDados = true;
                    });
                };
                
                $scope.consultar = function(paciente) {
                    $http.get($scope.urlAtual + 'rest/pacientes/' + paciente.codigo).success(function (data) {
                        console.log(data);
                        $scope.fields = data;
                    });
                };

                $scope.excluir = function(paciente) {
                    $http.delete($scope.urlAtual + 'rest/pacientes/' + paciente.codigo).success(function (data) {
                        console.log(data);
                        $scope.fields = data;
                        $scope.todos();
                    });
                };
                
                
                $scope.visualizar = function(paciente) {
                     $scope.selecionado = paciente;
                     console.log(paciente);
                };

                $scope.editar = function (obj) {
                    $scope.editarRegistro = true;
                    $scope.paciente = angular.copy(obj);
                };

                $scope.excluir = function (key) {
                    for (var i = 0; i < $scope.listaPaciente.length; i++) {
                        if ($scope.listaPaciente[i].id == key) {
                            $scope.listaPaciente.splice(i, 1);
                            $scope.pesquisa = '';
                        };
                    };
                };

                $scope.salvarEdicao = function () {
                    if (!$scope.paciente.nome || !$scope.paciente.email) {
                        alert('Campos obrigatórios não foram preenchidos!');
                        return;
                    }

                    $scope.excluir($scope.paciente.id);

                    $scope.paciente.id = $scope.getFakeID();
                    $scope.listaPaciente.push($scope.paciente);
                    $scope.editarRegistro = false;
                };

                $scope.cancelarEdicao = function () {
                    $scope.editarRegistro = false;
                };

                $scope.salvar = function () {
                    if (!$scope.paciente.nome || !$scope.paciente.email) {
                        alert('Campos obrigatórios não foram preenchidos!');
                        return;
                    }

                    $scope.paciente.id = $scope.getFakeID();
                    $scope.listaPaciente.push($scope.paciente);
                    $scope.redir('/paciente-lista');
                };
});