<#import "../parts/common.ftl" as c>

<@c.commonPage>
    <input type="hidden" id="source_message" value="${source}"/>
    <div class="text-center" style="white-space: pre-line">
        ${description}
    </div>
    <div class="row mx-0">
        <div class="col mx-0">
            <div class="accordion" id="accordionExample">
                <div class="card">
                    <div class="card-header" id="headingOne">
                        <h2 class="mb-0">
                            <button class="btn form-control submit-button" type="button" data-toggle="collapse" data-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                                <h5>Алфавит</h5>
                            </button>
                        </h2>
                    </div>

                    <div id="collapseOne" class="collapse show" aria-labelledby="headingOne" data-parent="#accordionExample">
                        <div class="card-body">
                            <div class="container">
                                <div class="row">
                                    <div class="col">110 - 'a'</div>
                                    <div class="col">111 - 'b'</div>
                                    <div class="col">112 - 'c'</div>
                                    <div class="col">113 - 'd'</div>
                                    <div class="col">114 - 'e'</div>
                                    <div class="col">115 - 'f'</div>
                                    <div class="col">116 - 'g'</div>
                                    <div class="col">117 - 'h'</div>
                                </div>
                                <div class="row">
                                    <div class="col">118 - 'i'</div>
                                    <div class="col">119 - 'j'</div>
                                    <div class="col">120 - 'k'</div>
                                    <div class="col">121 - 'l'</div>
                                    <div class="col">122 - 'm'</div>
                                    <div class="col">123 - 'n'</div>
                                    <div class="col">124 - 'o'</div>
                                    <div class="col">125 - 'p'</div>
                                </div>
                                <div class="row">
                                    <div class="col">126 - 'q'</div>
                                    <div class="col">127 - 'r'</div>
                                    <div class="col">128 - 's'</div>
                                    <div class="col">129 - 't'</div>
                                    <div class="col">130 - 'u'</div>
                                    <div class="col">131 - 'v'</div>
                                    <div class="col">132 - 'w'</div>
                                    <div class="col">133 - 'x'</div>
                                </div>
                                <div class="row">
                                    <div class="col">134 - 'y'</div>
                                    <div class="col">135 - 'z'</div>
                                    <div class="col">162 - 'а'</div>
                                    <div class="col">163 - 'б'</div>
                                    <div class="col">164 - 'в'</div>
                                    <div class="col">165 - 'г'</div>
                                    <div class="col">166 - 'д'</div>
                                    <div class="col">167 - 'е'</div>
                                </div>
                                <div class="row">
                                    <div class="col">168 - 'ё'</div>
                                    <div class="col">169 - 'ж'</div>
                                    <div class="col">170 - 'з'</div>
                                    <div class="col">171 - 'и'</div>
                                    <div class="col">172 - 'й'</div>
                                    <div class="col">173 - 'к'</div>
                                    <div class="col">174 - 'л'</div>
                                    <div class="col">175 - 'м'</div>
                                </div>
                                <div class="row">
                                    <div class="col">176 - 'н'</div>
                                    <div class="col">177 - 'о'</div>
                                    <div class="col">178 - 'п'</div>
                                    <div class="col">179 - 'р'</div>
                                    <div class="col">180 - 'с'</div>
                                    <div class="col">181 - 'т'</div>
                                    <div class="col">182 - 'у'</div>
                                    <div class="col">183 - 'ф'</div>
                                </div>
                                <div class="row">
                                    <div class="col">184 - 'х'</div>
                                    <div class="col">185 - 'ц'</div>
                                    <div class="col">186 - 'ч'</div>
                                    <div class="col">187 - 'ш'</div>
                                    <div class="col">188 - 'щ'</div>
                                    <div class="col">189 - 'ъ'</div>
                                    <div class="col">190 - 'ы'</div>
                                    <div class="col">191 - 'ь'</div>
                                </div>
                                <div class="row">
                                    <div class="col"></div>
                                    <div class="col"></div>
                                    <div class="col">192 - 'э'</div>
                                    <div class="col">193 - 'ю'</div>
                                    <div class="col">194 - 'я'</div>
                                    <div class="col"></div>
                                    <div class="col"></div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="pt-2 pb-2">
        <label for="train_message" class="form-label">Введите расшифрованное сообщение</label>
        <textarea id="train_message" class="form-control pt-2 pb-2" rows="3" placeholder="Расшифрованное сообщение..."></textarea>
    </div>

    <script src="js/training.js"></script>
</@c.commonPage>