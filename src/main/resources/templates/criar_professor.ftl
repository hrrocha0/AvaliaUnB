<#ftl encoding="UTF-8">
<#include "components/base.ftl">
<#include "components/form.ftl">

<@page>
    <div class="row justify-content-center">
        <div class="col-12 col-sm-8 my-3 my-sm-5">
            <h1 class="mb-3">Adicionar professor</h1>
            <@form>
                <@field "text" "matricula" "Matrícula"/>
                <@field "text" "nome" "Nome"/>
                <@field "email" "email" "Endereço de E-mail"/>

                <@submit>Adicionar</@submit>
            </@form>
        </div>
    </div>
</@page>