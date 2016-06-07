angular.module('MedicacoesModule', ['AppModule']).
        controller('MedicacoesController', ['$scope', '$rootScope', function ($scope, $rootScope, $location) {
                $scope.medicacao = {};
                $scope.paciente = null;
                
                $scope.urlApi = '/ProntuarioApp/rest';
                
                if ($rootScope.pacienteSelecionado !== null) {
                    $scope.paciente = $rootScope.pacienteSelecionado;
                    $scope.medicacao.pacienteId = $scope.paciente.id;
                }
                
                $scope.pesquisa = '';
                $scope.editarRegistro = false;
                
                $scope.salvar = function () {
                    console.log($scope.fields);
                    $http({
                        method: 'POST',
                        data: $scope.fields,
                        url: $scope.urlApi + '/medicacoes',
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
                    $http.get($scope.urlApi + '/medicacoes').success(function (data) {
                        $scope.listaMedicacao = data;
                        $scope.existemDados = true;
                    });
                };

                $scope.excluir = function(paciente) {
                    $http.delete($scope.urlApi + '/medicacoes/' + paciente.codigo).success(function (data) {
                        console.log(data);
                        $scope.fields = data;
                        $scope.todos();
                    });
                };
                
                $scope.excluir = function (key) {
                    for (var i = 0; i < $scope.listaMedicacao.length; i++) {
                        if ($scope.listaMedicacao[i].id === key) {
                            $scope.listaMedicacao.splice(i, 1);
                        }
                    }
                };

                $scope.salvar = function () {
                    if (!$scope.medicacao.nomeComercial || !$scope.medicacao.dose || !$scope.medicacao.frequencia || !$scope.medicacao.principioAtivo) {
                        alert('Campos obrigatórios não foram preenchidos!');
                        return;
                    }

                    $scope.medicacao.id = $scope.getFakeID();
                    $scope.listaMedicacao.push($scope.medicacao);
                    $scope.redir('/historico-medicacoes');
                };
                
                $scope.pesquisa = function(medicacao) {
                    if ($scope.paciente !== null) {
                        if (medicacao.pacienteId == $scope.paciente.id) {
                            return true;
                        }
                    }
                    return false;
                };
                
                $scope.selecionaPaciente = function() {
                    $rootScope.pacienteSelecionado = $scope.paciente;
                    $scope.todos();
                };
}]);
