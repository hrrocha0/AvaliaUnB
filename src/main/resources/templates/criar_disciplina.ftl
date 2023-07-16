<#ftl encoding="UTF-8">
<#include "components/base.ftl">
<#include "components/form.ftl">

<#-- @ftlvariable name="departamentos" type="kotlin.collections.List<kotlin.collections.Map<String, Object>>" -->

<@page>
    <div class="row justify-content-center">
        <div class="col-12 col-sm-8 my-3 my-sm-5">
            <h1 class="mb-3">Adicionar disciplina</h1>
            <@form>
                <@field "text" "codigo" "Código"/>
                <@field "text" "nome" "Nome"/>
                <@select "codigo_depto" "Departamento">
                    <#list departamentos as departamento>
                        <option value="${departamento.codigo}">${departamento.nome}</option>
                    </#list>
                </@select>

                <@submit>Adicionar</@submit>
            </@form>
        </div>
    </div>
</@page>