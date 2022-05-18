<#import "../parts/common.ftl" as c>

<@c.commonPage>
    <form>
        <div class="form-group">
            <div class="pt-2 pb-2">
                <label for="public_key" class="form-label">Введите публичный ключ</label>
                <input type="number" class="form-control" min="0" id="public_key">
            </div>
            <div class="pt-2 pb-2">
                <label for="number_N" class="form-label">Введите число N</label>
                <input type="number" class="form-control" min="0" id="number_N">
            </div>
            <div class="pt-2 pb-2">
                <label for="message" class="form-label">Введите Зашифрованное сообщение</label>
                <textarea if="message" class="form-control pt-2 pb-2" rows="3" placeholder="Введите своё сообщение, для попытки расшифровки"></textarea>
            </div>
            <button type="submit" class="btn btn-primary submit-button form-control pt-2 pb-2">Проверить</button>
        </div>
    </form>
</@c.commonPage>