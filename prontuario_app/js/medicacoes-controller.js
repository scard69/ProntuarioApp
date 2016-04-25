angular.module('MedicacaoModule', ['AppModule']).
        controller('MedicacaoController', ['$scope', function ($scope) {

                $scope.medicacao = {};
                $scope.listaMedicacoes = true;

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
}]);





