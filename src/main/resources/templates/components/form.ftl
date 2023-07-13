<#macro form action="" method="post">
    <form action="${action}" method="${method}">
        <#nested>
    </form>
</#macro>

<#macro field type id label="">
    <label class="form-label" for="${id}">${label}</label>
    <input class="form-control" type="${type}" id="${id}" name="${id}">
</#macro>

<#macro textarea id label rows>
    <div class="form-outline">
        <label for="${id}">${label}</label>
        <textarea class="form-control mt-2" id="${id}" name="${id}" rows="${rows}"></textarea>
    </div>
</#macro>

<#macro select id label>
    <label for="${id}">${label}</label>
    <select class="form-select my-2" id="${id}" name="${id}">
        <#nested>
    </select>
</#macro>

<#macro submit>
    <button class="btn btn-primary my-3 w-100" type="submit"><#nested></button>
</#macro>