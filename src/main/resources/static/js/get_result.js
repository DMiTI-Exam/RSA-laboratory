let timer = 60 * 5

function startTimer(display) {
    setInterval(function () {
        let minutes = Math.floor(timer / 60);
        let seconds = timer % 60;

        minutes = minutes < 10 ? "0" + minutes : minutes;
        seconds = seconds < 10 ? "0" + seconds : seconds;

        display.textContent = minutes + ":" + seconds;

        if (--timer < 0) {
            timer = 0;
        }
        getData();
        }
    , 1000);
}

function getData() {
    let pid = localStorage.getItem("pid")
    $.ajax({
        type: "POST",
        url: "check_progress/" + pid,
        error: function()
        {
            console.log("Произошла ошибка!");
        },
        beforeSend: function()
        {
            console.log("Отправляем данные...");
        },
        success: function(result)
        {
            if (result == "Timeout") {
                window.location = "/stable_rsa";
            } else if (result != "NONE"){
                window.location = "/poor_rsa";
            } else if (result == "NONE" && timer <= 0){
                window.location = "/stable_rsa";
            }
        }
    });
}

window.onload = function () {
    let display = document.querySelector('#time');
    startTimer(display);
}
