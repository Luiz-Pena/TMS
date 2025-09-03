
![[Pasted image 20250727152202.png]]

3. On branch main
Your branch is up to date with 'origin/main'.

Changes to be committed:
  (use "git restore --staged..." to unstage)
        new file:   meu_remoto

Untracked files:
  (use "git add ..." to include in what will be committed)
        hello.tmp

6. git remote rename origin r1
Renaming remote references: 100% (3/3), done.


![[Pasted image 20250727153238.png]]

5. On branch main
Your branch is ahead of 'r1/main' by 1 commit.
  (use "git push" to publish your local commits)

nothing to commit, working tree clean

6. diff --git a/hello.tmp b/hello.tmp
new file mode 100644
index 0000000..e69de29
diff --git a/meu_remoto b/meu_remoto
new file mode 160000
index 0000000..fd46b1a
--- /dev/null
+++ b/meu_remoto
@@ -0,0 +1 @@
+Subproject commit fd46b1a0f645638ec2b0742da06db9e124970dae

![[Pasted image 20250727154412.png]]

5. local -> remoto 
$ git diff r1 main
diff --git a/hello.tmp b/hello.tmp
new file mode 100644
index 0000000..e69de29
diff --git a/meu_remoto b/meu_remoto
new file mode 160000
index 0000000..fd46b1a
--- /dev/null
+++ b/meu_remoto
@@ -0,0 +1 @@
+Subproject commit fd46b1a0f645638ec2b0742da06db9e124970dae

colega -> local
retornou vazio, ja que estava na branch local do repositorio dele, sla

![[Pasted image 20250727154907.png]]

$ git branch dev1

luizh@LuizP MINGW64 ~/OneDrive/Documentos/TMS/meu_remoto (main)
$ git checkout dev1
Switched to branch 'dev1'

luizh@LuizP MINGW64 ~/OneDrive/Documentos/TMS/meu_remoto (dev1)
$ git add .

luizh@LuizP MINGW64 ~/OneDrive/Documentos/TMS/meu_remoto (dev1)
$ git commit -m "Editado em branch alt"
[dev1 a279c1b] Editado em branch alt
 1 file changed, 6 insertions(+)





