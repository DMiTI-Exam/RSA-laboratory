(function() {
    'use strict';
    window.addEventListener('load', function() {
        // Получите все формы, к которым мы хотим применить пользовательские стили проверки Bootstrap
        let forms = document.getElementsByClassName('needs-validation');
        // Зацикливайтесь на них и предотвращайте подчинение
        let validation = Array.prototype.filter.call(forms, function(form) {
            form.addEventListener('submit', function(event) {
                if (form.checkValidity() === false) {
                    event.preventDefault();
                    event.stopPropagation();
                }
                form.classList.add('was-validated');
            }, false);
        });
    }, false);
})();