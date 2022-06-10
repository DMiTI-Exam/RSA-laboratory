<#import "../parts/common.ftl" as c>

<@c.commonPage>
    <div class="alert alert-danger" role="alert">
        <h4 class="alert-heading">Сообщение расшифровано! Ваш RSA шифр не устойчив!</h4>
        <hr>
        <p>К вашему сожалению, сообщение удалось расшифровать...</p>
        <p>Вероятно, вы использовали слишком маленькие числа p и q, ну или сегодня просто не Ваш день. Настоятельно рекомендуем изменить ваш RSA шифр, ведь кроме нас его может взломать кто-то ещё. И не сказать Вам об этом...</p>
        <hr>
        <div id="cracked_message"></div>
    </div>
    <script src="js/show_cracked_message.js"></script>
</@c.commonPage>