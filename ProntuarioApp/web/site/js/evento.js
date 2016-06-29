$(document).ready(function () {
    $('#login-button').click(function (event) {
        event.preventDefault();

        $('#form').fadeOut("slow");
        $('.wrapper').addClass('form-success');
    });
});