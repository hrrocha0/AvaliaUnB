<#ftl encoding="UTF-8">
<#include "components/base.ftl">

<#-- @ftlvariable name="professores" type="kotlin.collections.List<kotlin.collections.Map<String, Object>>" -->
<#-- @ftlvariable name="perfil" type="kotlin.collections.Map<String, Object>"-->

<@page>
    <div class="row justify-content-center">
        <div class="col-12 col-sm-8 my-3 my-sm-5">
            <h1 class="mb-3">Professores</h1>

            <table class="table table-striped">
                <tr>
                    <td>Matricula</td>
                    <td>Nome</td>
                    <td>Endereço e-mail</td>
                    <td>Ações</td>
                </tr>
                <#list professores as professor>
                    <tr>
                        <td>${professor.matricula}</td>
                        <td>${professor.nome}</td>
                        <td>${professor.email}</td>
                        <td>
                            <div class="row">
                                <#if perfil.admin>
                                    <div class="col text-center">
                                        <a class="btn btn-primary" href="/professor/${professor.id}/editar">Editar</a>
                                    </div>
                                    <div class="col text-center">
                                        <a class="btn btn-primary" href="/professor/${professor.id}/deletar">Deletar</a>
                                    </div>
                                <#else>
                                    <div class="col text-center">
                                        <a class="btn btn-primary" href="">Avaliações</a>
                                    </div>
                                </#if>
                            </div>
                        </td>
                    </tr>
                </#list>
            </table>
            <#if perfil.admin>
                <a class="btn btn-primary" href="/professor/criar">Adicionar</a>
            </#if>
        </div>
    </div>
</@page>