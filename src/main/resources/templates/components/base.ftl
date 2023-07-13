<#include "libraries.ftl">

<#-- @ftlvariable name="perfil" type="kotlin.collections.Map<String, Object>" -->

<#macro page>
    <!DOCTYPE html>
    <html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>AvaliaUnB</title>
        <@bootstrapCSS/>
    </head>
    <body>
    <nav class="navbar navbar-expand-sm navbar-dark bg-dark">
        <div class="container-xxl">
            <a class="navbar-brand" href="/">AvaliaUnB</a>
            <button type="button" class="navbar-toggler" data-bs-toggle="collapse" data-bs-target="#navbarNav"
                    aria-controls="navbarNav" aria-expanded="false" aria-label="Alternar Navegação">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse">
                <ul class="navbar-nav">
                    <li><a class="nav-link" href="/">Início</a></li>
                    <li><a class="nav-link" href="">Disciplinas</a></li>
                    <li><a class="nav-link" href="/professor">Professores</a></li>
                </ul>
                <#if perfil??>
                    <ul class="navbar-nav ms-auto">
                        <li><a class="nav-link" href="">${perfil.matricula}</a></li>
                    </ul>
                <#else>
                    <ul class="navbar-nav ms-auto">
                        <li><a class="nav-link" href="/entrar">ENTRAR</a></li>
                    </ul>
                </#if>
            </div>
        </div>
    </nav>
    <main class="container">
        <#nested>
    </main>
    <@bootstrapJS/>
    </body>
    </html>
</#macro>