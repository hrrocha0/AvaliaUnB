<#macro form action="" method="post">
    <form action="${action}" method="${method}">
        <#nested>
    </form>
</#macro>

<#macro field type id label="">
    <label for="${id}">${label}</label>
    <input type="${type}" id="${id}" name="${id}">
</#macro>

<#macro submit>
    <button type="submit"><#nested></button>
</#macro>