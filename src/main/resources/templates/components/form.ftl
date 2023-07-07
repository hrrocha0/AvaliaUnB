<#macro form action="" method="post">
    <form action="${action}" method="${method}">
        <#nested>
    </form>
</#macro>

<#macro field type id label="">
    <label class="form-label" for="${id}">${label}</label>
    <input class="form-control" type="${type}" id="${id}" name="${id}">
</#macro>

<#macro submit>
    <button class="btn btn-primary my-3 w-100" type="submit"><#nested></button>
</#macro>