<#import "../parts/common.ftl" as c>

<@c.commonPage>
    <div>
        <form>
            <div class="mb-3">
                <label for="public_key" class="form-label">Вставьте публичный ключ</label>
                <input type="number" class="form-control" min="0" id="public_key">
            </div>
            <div class="mb-3">
                <label for="number_N" class="form-label">Вставьте число N</label>
                <input type="number" class="form-control" min="0" id="number_N">
            </div>
            <div class="mb-3 form-check ">
            </div>
            <button type="submit" class="btn btn-primary submit-button">Проверить</button>
        </form>
    </div>
</@c.commonPage>