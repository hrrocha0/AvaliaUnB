<#macro page>
    <!DOCTYPE html>
    <html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <title>AvaliaUnB</title>
    </head>
    <body>
    <nav>
        <a href="/">AvaliaUnB</a>
        <ul>
            <li><a href="">Início</a></li>
            <li><a href="">Disciplinas</a></li>
            <li><a href="">Professores</a></li>
        </ul>
        <ul>
            <li><a href="">ENTRAR</a></li>
        </ul>
    </nav>
    <main>
        <#nested>
    </main>
    </body>
    </html>
</#macro>