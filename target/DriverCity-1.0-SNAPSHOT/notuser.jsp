<!DOCTYPE html>
<html>
<head>
    <title>Интернет магазин</title>
</head>
<body>
<span onclick="loadCart()">Моя корзина</span>
<div id="store"></div>
<script>
    function loadCart(){
        fetch('/cart_ajax.html').then(
            function(response) {
                return response.text();
            }
        ).then(
            function(text) {
                document.getElementById('store').innerHTML = text;
            }
        );
    }
</script>
</body>
</html>