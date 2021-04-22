for $a in /fruteria/fruta
return <fruta>
<nombre>{data($a/nombre)}</nombre>
<precio>{data($a/precio[@mes="febrero"])}</precio>
</fruta>