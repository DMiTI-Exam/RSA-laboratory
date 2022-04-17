<nav class="navbar fixed-top navbar-expand-lg navbar-dark bg-success">
    <a class="navbar-brand" href="/">RSA Laboratory</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link " href="/">Главная страница <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="...">Пункт 1 <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="...">Пункт 2 <span class="sr-only">(current)</span></a>
            </li>
        </ul>

        <a class="btn p-0" id="usaLocale" href="" onclick="toUSALocale()">
            <img src="https://img.icons8.com/color/40/000000/usa-circular.png" class="d-inline-block align-top" alt="US"/>
        </a>

        <a class="btn p-0" id="ruLocale" href="" onclick="toRussianLocale()">
            <img src="https://img.icons8.com/color/40/000000/russian-federation-circular.png" class="d-inline-block align-top" alt="RU"/>
        </a>
    </div>

    <script>
        function toUSALocale() {
            let url = window.location.href;
            if (url.includes("?")) {
                if (url.includes("lang")) {
                    let index = url.indexOf("lang");
                    url = url.slice(0, index)
                }
                url+="&lang=US";
            } else {
                url+="?lang=US";
            }
            $("#usaLocale").attr("href", url);
        }
        function toRussianLocale() {
            let url = window.location.href;
            if (url.includes("?")) {
                if (url.includes("lang")) {
                    let index = url.indexOf("lang");
                    url = url.slice(0, index)
                }
                url+="&lang=RU";
            } else {
                url+="?lang=RU";
            }
            $("#ruLocale").attr("href", url);
        }
    </script>
</nav>