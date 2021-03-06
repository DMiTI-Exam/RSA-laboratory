<#import "parts/common.ftl" as c>

<@c.commonPage>
    <div>
        <h3>Добро пожаловать в лабораторию тестирования устойчивости RSA шифра</h3>
        <br/>
        <div>
            <p>Данный проект позволит узнать о методе циклического взлома RSA</p>
            <p>Вкладка <a href="/rsa_generator">RSA генератор</a> позволяет создать RSA шифр с пользовательскими параметрами</p>
            <p>Вкладка <a href="/laboratory">Лаборатория</a> позволяет проверить созданный RSA шифр на устойчивость к циклическому взлому</p>
            <p>Вкладка <a href="/training">Тренажёр</a> позволяет самостоятельно потренироваться в циклическом взломе на простых RSA</p>
            <p>Основная идея проекта - c<sup>e<sup>s</sup></sup> mod N &equiv; c &#8658; c<sup>e<sup>s-1</sup></sup> mod N &equiv; m</p>
        </div>
    </div>
</@c.commonPage>