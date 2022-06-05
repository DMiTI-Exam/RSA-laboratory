<#import "../parts/common.ftl" as c>

<@c.commonPage>
    <input type="hidden" id="source_message" value="${source}"/>
    <div class="text-center" style="white-space: pre-line">
        ${description}
    </div>
    <!--form action="/decrypt_process" method="post">
        <div class="form-group">
            <div class="pt-2 pb-2">
                <label for="message" class="form-label">Введите расшифрованное сообщение</label>
                <textarea id="message" name="message" class="form-control pt-2 pb-2" rows="3" placeholder="Расшифрованное сообщение..."></textarea>
            </div>
            <button type="submit" class="btn btn-primary submit-button form-control pt-2 pb-2">Проверить</button>
        </div>
    </form-->

    <div class="pt-2 pb-2">
        <label for="train_message" class="form-label">Введите расшифрованное сообщение</label>
        <textarea id="train_message" class="form-control pt-2 pb-2" rows="3" placeholder="Расшифрованное сообщение..."></textarea>
    </div>

    <script src="js/training.js"></script>
</@c.commonPage>