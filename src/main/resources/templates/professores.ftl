<#ftl encoding="UTF-8">
<#include "components/base.ftl">

<#-- @ftlvariable name="professores" type="kotlin.collections.List<kotlin.collections.Map<String, Object>>" -->
<#-- @ftlvariable name="perfil" type="kotlin.collections.Map<String, Object>"-->

<@page>
    <div class="row justify-content-center">
        <div class="col-12 col-sm-8 my-3 my-sm-5">
            <h1 class="mb-3">Professores</h1>

            <#if perfil.administrador>
                <a class="btn btn-primary" href="/professor/criar">Adicionar</a>
            </#if>
            <table class="table table-striped">
                <tr>
                    <td>Nome</td>
                    <td>Departamento</td>
                    <td>Ações</td>
                </tr>
                <#list professores as professor>
                    <tr>
                        <td>${professor.nome}</td>
                        <td>${professor.codigo_depto}</td>
                        <td>
                            <div class="row">
                                <#if perfil.administrador>
                                    <div class="col text-center">
                                        <a class="btn btn-primary" href="/professor/${professor.codigo_p_ou_d}/editar">Editar</a>
                                    </div>
                                    <div class="col text-center">
                                        <a class="btn btn-primary" href="/professor/${professor.codigo_p_ou_d}/deletar">Deletar</a>
                                    </div>
                                </#if>
                            </div>
                        </td>
                    </tr>
                </#list>
            </table>
        </div>
    </div>
</@page>