<#ftl encoding="UTF-8">
<#include "components/base.ftl">
<#include "components/form.ftl">

<#-- @ftlvariable name="professor" type="kotlin.collections.Map<String, Object>" -->

<@page>
    <div class="row justify-content-center">
        <div class="col-12 col-sm-8 my-3 my-sm-5">
            <h1 class="mb-3">Editar professor: ${professor.nome}</h1>
            <@form>
                <@field "text" "matricula" "Matrícula"/>
                <@field "text" "nome" "Nome"/>
                <@field "email" "email" "Endereço de E-mail"/>

                <@submit>Salvar</@submit>
            </@form>
        </div>
    </div>
</@page>