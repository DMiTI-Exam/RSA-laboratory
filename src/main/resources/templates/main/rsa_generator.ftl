<#import "../parts/common.ftl" as c>

<@c.commonPage>
    <form action="/rsa_generator" method="post">
        <div class="form-group">
            <div class="row pt-2 pb-2">
                <div class="col mx-auto">
                    <div class="text-center">
                        Минимальная битовая длина (2^(n-1) + 1)
                    </div>
                </div>
            </div>
            <div class="row justify-content-between pt-2 pb-2">
                <div class="col">
                    <div class="row justify-content-center">
                        <div class="col-2">
                            <span class="mr-0" id="p-min">p (5):</span>
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
                <div class="col">
                    <div class="row justify-content-center">
                        <div class="col-2">
                            <span class="mr-0" id="q-min">q (93):</span>
                        </div>
                        <div class="col-xs">
                            <span class="ml-0 mr-0">5</span>
                        </div>
                        <div class="col-5 my-auto">
                            <input id="q-min-value" name="q_min_value" type="range" value="5" min="5" max="93" class="form-control-range w-100  ml-0 mr-0">
                        </div>
                        <div class="col-xs">
                            <span class="ml-0">93</span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row  pt-2 pb-2">
                <div class="col mx-auto">
                    <div class="text-center">
                        Максимальная битовая длина (2^n - 1)
                    </div>
                </div>
            </div>
            <div class="row justify-content-between pt-2 pb-2">
                <div class="col">
                    <div class="row justify-content-center">
                        <div class="col-2">
                            <span class="mr-0" id="p-max">p (5):</span>
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
                <div class="col">
                    <div class="row justify-content-center">
                        <div class="col-2">
                            <span class="mr-0" id="q-max">q (93):</span>
                        </div>
                        <div class="col-xs">
                            <span class="ml-0 mr-0">5</span>
                        </div>
                        <div class="col-5 my-auto">
                            <input id="q-max-value" name="q_max_value" type="range" value="93" min="5" max="93" class="form-control-range w-100  ml-0 mr-0">
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
                    <button type="submit" class="btn btn-primary submit-button form-control">Сгенерировать RSA</button>
                </div>
            </div>

            <#if encodedMessage??>
                <div class="row pt-2 pb-2 mt-5">
                    <div class="col pl-5 pr-5">
                        <label for="code">Зашифрованное сообщение:</label>
                        <textarea id="code" class="form-control" rows="6"><#list encodedMessage as m>${m} </#list></textarea>
                    </div>
                </div>
            </#if>
        </div>
    </form>
    <script src="/js/valueChanger.js"></script>
</@c.commonPage>