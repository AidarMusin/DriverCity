// Мы подключим библиотеку jQuery и создали базовую HTML-разметку,
//     а также подключили файл ajax.js, далее нам нужно будет создать этот файл.
// Обратите внимание, что метод отправки формы у нас POST, задан id="ajax_form" и action="".
// Также, после формы мы добавили div c id=result_form. Именно в этот div мы будем выводить результат обработки формы.
//
//
//     Теперь создадим второй файл - ajax.js

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

// В файле ajax.js есть два метода: $("#btn").click и sendAjaxForm. Первый метод - это слушатель событий кнопки.
// То есть, когда мы нажимаем на кнопку "Отправить", слушатель срабатывает и вызывает метод sendAjaxForm.
//
// В метод sendAjaxForm(result_form, ajax_form, url) передаются поля: result_form - это div в который будут рендерится данные,
// ajax_form - это id формы отправки сообщения и url - это местоположение файла action_ajax_form.php
// который отвечает за серверную часть (обработка формы).