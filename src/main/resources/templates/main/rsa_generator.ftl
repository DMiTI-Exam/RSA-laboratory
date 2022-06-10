<#import "../parts/common.ftl" as c>

<@c.commonPage>
    <#if encodedMessage??>
        <div class="alert alert-primary" role="alert">
            <h4 class="alert-heading">Ваш RSA</h4>
            <hr>
            <p id="code" style="word-wrap: break-word">N = ${N}, e = ${e}<br/><#list encodedMessage as m>${m} </#list></p>
        </div>
    </#if>
    <form action="/rsa_generator" method="post">
        <div class="form-group">
            <div class="row pt-2 pb-2">
                <div class="col mx-auto">
                    <div class="text-center" id="min-num">
                        Минимальная битовая длина n<br/>Минимальное соответсвующее число 2<sup>n-1</sup> + 1: (17)
                    </div>
                </div>
            </div>
            <div class="row pt-2 pb-2">
                <div class="col">
                    <div class="row justify-content-center">
                        <div class="col-2">
                            <span class="mr-0" id="p-min">min (5):</span>
                        </div>
                        <div class="col-xs">
                            <span class="ml-0 mr-0">5</span>
                        </div>
                        <div class="col-5 my-auto">
                            <input id="p-min-value" name="p_min_value" type="range" value="5" min="5" max="93" class="form-control-range w-100  ml-0 mr-0">
                        </div>
                        <div class="col-xs">
                            <span class="ml-0">93</span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row  pt-2 pb-2">
                <div class="col mx-auto">
                    <div class="text-center" id="max-num">
                        Максимальная битовая длина n<br/>Максимальное соответсвующее число 2<sup>n</sup> - 1: (4.951760157141521e+27)
                    </div>
                </div>
            </div>
            <div class="row justify-content-between pt-2 pb-2">
                <div class="col">
                    <div class="row justify-content-center">
                        <div class="col-2">
                            <span class="mr-0" id="p-max">max (5):</span>
                        </div>
                        <div class="col-xs">
                            <span class="ml-0 mr-0">5</span>
                        </div>
                        <div class="col-5 my-auto">
                            <input id="p-max-value" name="p_max_value" type="range" value="93" min="5" max="93" class="form-control-range w-100  ml-0 mr-0">
                        </div>
                        <div class="col-xs">
                            <span class="ml-0">93</span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row pt-2 pb-2">
                <div class="col mx-auto">
                    <div id="e-min" class="text-center">
                        Нижняя граница e (3)
                    </div>
                </div>
            </div>
            <div class="row pt-2 pb-2">
                <div class="col">
                    <div class="row justify-content-center">
                        <div class="col-xs">
                            <span>3</span>
                        </div>
                        <div class="col-10 my-auto">
                            <input id="e-min-value" name="e_min_value" type="range" value="3" min="3" max="500" class="form-control-range w-100  ml-0 mr-0">
                        </div>
                        <div class="col-xs">
                            <span>500</span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row pt-2 pb-2">
                <div class="col pl-5 pr-5">
                    <#if message??>
                        <textarea class="form-control" name="message" rows="6">${message}</textarea>
                    <#else>
                        <textarea class="form-control" name="message" rows="6" placeholder="Введите своё сообщение для шифрования"></textarea>
                    </#if>
                </div>
            </div>
            <div class="row pt-2 pb-2">
                <div class="col pl-5 pr-5">
                    <button type="submit" class="btn btn-primary form-control submit-button">Сгенерировать RSA</button>
                </div>
            </div>
        </div>
    </form>
    <script src="/js/valueChanger.js"></script>
</@c.commonPage>