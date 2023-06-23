<#ftl encoding="UTF-8">
<#include "components/base.ftl">
<#include "components/form.ftl">

<@page>
    <h1>Registrar</h1>
    <@form>
        <@field "text" "matricula" "Matrícula"/>
        <@field "text" "nome" "Nome Completo"/>
        <@field "email" "email" "Endereço de e-mail"/>
        <@field "password" "senha" "Senha"/>
        <@field "password" "confirmar" "Confirmar Senha"/>

        <@submit>Registrar</@submit>

        <p>Já possui uma conta? <a href="/entrar">Entrar</a></p>
    </@form>
</@page>