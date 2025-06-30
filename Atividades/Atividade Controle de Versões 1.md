![[Pasted image 20250627102459.png]]

     1. Eu teria uma lista de planos de implementações no software, que a implementação de 1 ou vários desses incrementos mudaria o primeiro número, o segundo numero eu acrescentaria caso ocorra algum incremento solicitado pelos usuários, clientes, etc. Por fim o ultimo número seria incrementado a medida que erros forem encontrados. Eu acredito que seguindo essa regra, ocorreria uniformidade no que é esperado em cada novo versionamento.
     2. 1.0 Release
     3. 1.1
     4. Programa 1.0, 1.1, futuras atualizações poderiam fazer com que o historico expanda para por exemplo 1.0, 1.1, 1.1.1, 1.1.2, 1.2.
   
![[Pasted image 20250627103329.png]]
`5. A versão mais recente seria 1.2.2`
`5. 1.0, 1.1, 1.1.1, 1.1.2, 1.1.3, 1.2.0, 1.2.1, 1.2.2, 1.3, 1.4, 1.4.1, 1.4.2`
`5. A versão do android 1.5 era conhecido como cupcake, em seguida suas versões 2.0 e 2.1 também receberam nome de doces: Eclair, seguido por Froyo, Kitkat

![[Pasted image 20250627104736.png]]

`Todos os passos já foram feitos anteriormente, a ajuda no git mostra alguns comandos simples mas que já dao um norte para quem esta começando`

![[Pasted image 20250627105005.png]]

1. `https://github.com/Team-EnderIO/EnderIO, https://github.com/AppliedEnergistics/Applied-Energistics-2 e https://github.com/mekanism/Mekanism`
2. `Foi criado uma pasta contendo o que havia no repositório remoto`
3. `Foi criado uma pasta .git`
4. `Pelo netbeans é possível ver alterações feitas nos arquivos java, como por exemplo arquivo adicionado`

![[Pasted image 20250627114223.png]]
1. `o git status mostrou em vermelho as alterações feitas e deu algumas dicas para subir essas alterações`
2. `error: the following file has changes staged in the index:`
    `hello.md`
`(use --cached to keep the file, or -f to force removal)`

![[Pasted image 20250627115239.png]]
`commit ca82a6dff817ec66f44342007202690a93763949 (HEAD -> master, origin/master, origin/HEAD)`
`Author: Scott Chacon <schacon@gmail.com>`
`Date:   Mon Mar 17 21:52:11 2008 -0700`

    `changed the verison number`

`commit 085bb3bcb608e1e8451d4b2432f8ecbe6306e7e7`
`Author: Scott Chacon <schacon@gmail.com>`
`Date:   Sat Mar 15 16:40:33 2008 -0700`

    `removed unnecessary test code`

`commit a11bef06a3f659402fe7563abf99ad00de2209e6`
`Author: Scott Chacon <schacon@gmail.com>`
`Date:   Sat Mar 15 10:31:28 2008 -0700`

    `first commit`

![[Pasted image 20250627115638.png]]
1. git log -p mostrou que a diferença entre os commits foi a version.s, de 0.1.0 para 0.1.1. git log --stat mostrou os commits e suas alterações como arquivos modificados, apagados. git log --pretty=onelina mostrou todos os commits e o nome de cada um junto com o log. git log --pretty=short, por sua vez mostrou o id do commit, informações do autor e o nome do commit. git log --pretty=full por algum motivo mostrou as mesmas informações de autor e commit, seguido pelo nome do commit, git log --pretty=fuller mostrou os dados do autor, a data que o autor fez o commit, a data do commit e informações do autor, as duas ultimas repetidas das duas primeiras. git log --pretty=format: "" é possivel passar um formato, igual no printf em C, e as informações serão mostradas de acordo com esse formato
2. Não foi mostrado nada, o que indica que não há commits com essas especificações

![[Pasted image 20250628141000.png]]
git diff não mostrou nenhuma informação. (esqueci de dar ctrl + S)

![[Pasted image 20250628141634.png]]
4. "diff --git a/referencias.md b/referencias.md
index e69de29..5cadd79 100644
--- a/referencias.md
+++ b/referencias.md
@@ -0,0 +1 @@
+file:///C:/Program%20Files/Git/mingw64/share/doc/git-doc/git-restore.html
\ No newline at end of file
diff --git a/reparo.md b/reparo.md
index 1d548c1..c195112 100644
--- a/reparo.md
+++ b/reparo.md
@@ -1,7 +1 @@
-git commit --amend -m "Novo nome do commit"
-
-ou apenas
-
-git commit -amend
-git restore --staged {nome do arquivo}
-git restore --worktree {nome do arquivo}
\ No newline at end of file"

![[Pasted image 20250628142822.png]]

1. O repositorio clonado nao houve uso de tags, porém o escolhido sim, o esquema de versionamento é o semver
2. Cada commit posui informação de namespace, pre-release, patch, major, minor

![[Pasted image 20250628143354.png]]

4. usando o filtro git tag -l "1.1.*" nao houve nada a ser retornado
5. Tag1
Tag_2
tag_3
6. commit f1f8eb82d0340d71866807eff9228ca1da3b8a0a (HEAD -> main, tag: Tag_2, tag: Tag1)
