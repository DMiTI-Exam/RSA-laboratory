<#macro commonPage>
    <!DOCTYPE html>
    <html lang="en">

    <head>
        <meta charset="UTF-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>

        <title>RSA</title>
        <link href="https://fonts.googleapis.com/css2?family=Jura:wght@300;500&display=swap" rel="stylesheet">
        <link type="text/css" rel="stylesheet" href="/webjars/bootstrap/4.5.0/css/bootstrap.min.css"/>
        <link type="text/css" rel="stylesheet" href="/css/common.css"/>
        <link type="text/css" rel="stylesheet" href="/css/neon.css"/>


        <link rel="shortcut icon" type="image/x-icon" href="https://img.icons8.com/dusk/32/000000/data-encryption.png"/>
    </head>

    <body>
        <script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
        <script src="/webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>
        <script src="/webjars/popper.js/1.16.0/umd/popper.min.js"></script>

        <#include "navbar.ftl">
        <div class="container text-light text-center" xmlns="http://www.w3.org/1999/html">
            <#nested>
        </div>

        <div class='light x1'></div>
        <div class='light x2'></div>
        <div class='light x3'></div>
        <div class='light x4'></div>
        <div class='light x5'></div>
        <div class='light x6'></div>
        <div class='light x7'></div>
        <div class='light x8'></div>
        <div class='light x9'></div>
    </body>
    </html>
</#macro>