<#ftl encoding="UTF-8">
<#include "components/base.ftl">
<#include "components/form.ftl">

<#-- @ftlvariable name="feedback" type="kotlin.collections.Map<String, Object>" -->

<@page>
    <div class="row justify-content-center">
        <div class="col-12 col-sm-8 my-3 my-sm-5">
            <h1 class="mb-3">Registrar</h1>

            <#if feedback.type == "error">
                <#if feedback.message??>
                    <div class="alert alert-danger alert-dismissable fade show" role="alert">
                        <div class="d-flex">
                            ${feedback.message}
                            <button type="button" class="btn-close ms-auto" data-bs-dismiss="alert"
                                    aria-label="Fechar"></button>
                        </div>
                    </div>
                </#if>
            </#if>
            <@form>
                <@field "text" "matricula" "Matrícula"/>
                <@field "text" "nome" "Nome Completo"/>
                <@field "email" "email" "Endereço de e-mail"/>
                <@field "password" "senha" "Senha"/>
                <@field "password" "confirmar" "Confirmar Senha"/>

                <@submit>Registrar</@submit>

                <div class="text-center">
                    <p>Já possui uma conta? <a href="/entrar">Entrar</a></p>
                </div>
            </@form>
        </div>
    </div>
</@page>