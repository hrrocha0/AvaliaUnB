<#ftl encoding="UTF-8">
<#include "components/base.ftl">

<#-- @ftlvariable name="disciplinas" type="kotlin.collections.List<kotlin.collections.Map<String, Object>>" -->
<#-- @ftlvariable name="perfil" type="kotlin.collections.Map<String, Object>" -->

<@page>
    <div class="row justify-content-center">
        <div class="col-12 col-sm-8 my-3 my-sm-5">
            <h1 class="mb-3">Disciplinas</h1>

            <#if perfil.administrador>
                <a class="btn btn-primary" href="/disciplina/criar">Adicionar</a>
            </#if>
            <table class="table table-striped">
                <tr>
                    <td>Código</td>
                    <td>Nome</td>
                    <td>Departamento</td>
                    <td>Ações</td>
                </tr>
                <#list disciplinas as disciplina>
                    <tr>
                        <td>${disciplina.codigo}</td>
                        <td>${disciplina.nome}</td>
                        <td>${disciplina.codigo_depto}</td>
                        <td>
                            <div class="row">
                                <#if perfil.administrador>
                                    <div class="col text-center">
                                        <a class="btn btn-primary"
                                           href="/disciplina/${disciplina.codigo_p_ou_d}/editar">Editar</a>
                                    </div>
                                    <div class="col text-center">
                                        <a class="btn btn-primary"
                                           href="/disciplina/${disciplina.codigo_p_ou_d}/deletar">Deletar</a>
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