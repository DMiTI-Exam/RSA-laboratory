<#import "../parts/common.ftl" as c>

<@c.commonPage>
    <form id="laboratory" action="/decrypt_process" method="post">
        <div class="form-group">
            <div class="pt-2 pb-2">
                <label for="number_N" class="form-label">Введите число N</label>
                <input type="number" name="number_N" class="form-control" min="0" id="number_N">
            </div>
            <div class="pt-2 pb-2">
                <label for="number_e" class="form-label">Введите число e</label>
                <input type="number" name="number_e" class="form-control" min="0" id="number_e">
            </div>
            <div class="pt-2 pb-2">
                <label for="message" class="form-label">Введите зашифрованное сообщение</label>
                <textarea id="message" name="message" class="form-control pt-2 pb-2" rows="3" placeholder="Введите своё сообщение, для попытки расшифровки"></textarea>
            </div>
            <button type="button" name="send" id="sendToCheck" class="btn btn-primary submit-button form-control pt-2 pb-2">Проверить</button>
        </div>
    </form>
    <script src="js/add_id.js"></script>
</@c.commonPage>