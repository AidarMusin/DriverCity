
/* Article FructCode.com */
$( document ).ready(function() {
    $("#btnsend").click(
        function(){
            sendAjaxForm('result_form', 'checkedForm', '/find');
            return false;
        }
    );
});

function sendAjaxForm(result_form, checkedForm, url) {
    $.ajax({
        url:     url, //url страницы (action_ajax_form.php)
        type:     "POST", //метод отправки
        dataType: "html", //формат данных
        data: $("#"+checkedForm).serialize(),  // Сеарилизуем объект
        contentType: "application/json",
        success: function(response) { //Данные отправлены успешно
            result = $.parseJSON(response);
            $('#result_form').html('Name: '+result.name+' City: '+result.city + ' Car:'+result.valueCars);
        },
        error: function(response) { // Данные не отправлены
            $('#result_form').html('Ошибка. Данные не отправлены.');
        }
    });
}

