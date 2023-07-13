<#ftl encoding="UTF-8">
<#include "components/base.ftl">
<#include "components/form.ftl">

<#-- @ftlvariable name="professor" type="kotlin.collections.Map<String, Object>" -->

<@page>
    <div class="row justify-content-center">
        <div class="col-12 col-sm-8 my-3 my-sm-5">
            <h1 class="mb-3">Deletar professor: ${professor.nome}</h1>

            <div class="card text-center">
                <div class="card-body">
                    Você não pode reverter essa ação. Continuar mesmo assim?

                    <@form>
                        <@submit>Continuar</@submit>
                    </@form>
                </div>
            </div>
        </div>
    </div>
</@page>