<#import "../parts/common.ftl" as c>

<@c.commonPage>
    <form>
        <div class="mb-3">
            <label for="p_value" id="p" class="form-label">Минимальная битовая длина (2^(n-1)+1) для числа p [3]:</label>
            <input type="range" class="form-control" min="5" max="93" value="3" id="p_value">
        </div>
        <div class="mb-3">
            <label for="q_value" id="q" class="form-label">Минимальная битовая длина (2^(n-1)+1) для числа q [3]:</label>
            <input type="range" class="form-control" min="5" max="93" value="3" id="q_value">
        </div>
        <div class="mb-3">
            <label for="degree" id="e" class="form-label">Нижняя граница степени e [3]:</label>
            <input type="range" class="form-control" min="3" max="500" value="3" id="degree">
        </div>
        <div class="mb-3">
            <label for="message" class="form-label">Сообщение:</label>
            <input type="text" class="form-control" id="message">
        </div>
        <div class="mb-3 form-check">
        </div>
        <button type="submit" class="btn btn-primary submit-button">Сгенерировать RSA</button>
    </form>
    <script src="/js/valueChanger.js"></script>
</@c.commonPage>