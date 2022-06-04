<#import "../parts/common.ftl" as c>

<@c.commonPage>
    <form action="/decrypt_process" method="post">
        <div class="form-group">
            <div class="pt-2 pb-2">
                <label for="message" class="form-label">Введите расшифрованное сообщение</label>
                <textarea id="message" name="message" class="form-control pt-2 pb-2" rows="3" placeholder="Расшифрованное сообщение..."></textarea>
            </div>
            <button type="submit" class="btn btn-primary submit-button form-control pt-2 pb-2">Проверить</button>
        </div>
    </form>
</@c.commonPage>