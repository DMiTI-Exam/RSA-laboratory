$(document).ready(function()
{
    $("#sendToCheck").click(function()
    {
        if ($("#message").hasClass("bg-danger") || $("#message").val() === "") {
            alert("Вам необходимо заполнить поле с сообщением корректно")
        } else {
            const array = new Uint32Array(1);
            window.crypto.getRandomValues(array);
            console.log(array[0]);
            localStorage.setItem('pid', array[0] + "");
            $.ajax(
                {
                    type: "POST",
                    url: "decrypt_process",
                    data: $("#laboratory").serialize() + '&pid=' + array[0] + "",
                    error: function () {
                        console.log("Произошла ошибка!");
                    },
                    beforeSend: function () {
                        console.log("Отправляем данные...");
                    },
                    success: function (result) {
                        window.location = "/decrypt_process"
                    }
                });
            return false;
        }
    });

    $("#message").on("keyup paste input change", function () {
        if (/^\d+[ ]?([0-9]+[ ]?)*$/.test($("#message").val())) {
            $("#message").removeClass("bg-danger");
        } else {
            $("#message").addClass("bg-danger");
        }
    });
});