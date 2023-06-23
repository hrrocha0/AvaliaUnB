<#ftl encoding="UTF-8">
<#include "components/base.ftl">
<#include "components/form.ftl">

<@page>
    <h1>Entrar</h1>
    <@form>
        <@field "text" "matricula" "Matrícula"/>
        <@field "password" "senha" "Senha"/>

        <@submit>Entrar</@submit>

        <p>Não possui uma conta? <a href="/registrar">Registrar</a></p>
    </@form>
</@page>