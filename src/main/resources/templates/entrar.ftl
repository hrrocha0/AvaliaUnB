<#ftl encoding="UTF-8">
<#include "components/base.ftl">
<#include "components/form.ftl">

<#-- @ftlvariable name="feedback" type="kotlin.collections.Map<String, Object>" -->

<@page>
    <h1>Entrar</h1>

    <#if feedback.type == "error">
        <#if feedback.message??>
            <p>${feedback.message}</p>
        </#if>
    </#if>

    <@form>
        <@field "text" "matricula" "Matrícula"/>
        <@field "password" "senha" "Senha"/>

        <@submit>Entrar</@submit>

        <p>Não possui uma conta? <a href="/registrar">Registrar</a></p>
    </@form>
</@page>