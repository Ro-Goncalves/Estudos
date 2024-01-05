import { PaginationProduct } from "@/models";
import { ProductsList } from "../components/ProductList";
import { makeSearchLink } from "@/utils";
import { Suspense } from "react";
import { Loading } from "../components/Loading";

async function ProductsListPage({
    searchParams,
}: {
    searchParams: { name?: string, page? : string }
}){
    const { name } = searchParams;
    const page = searchParams.page ? parseInt(searchParams.page) : 1;
    
    return(
        <div className="m-2">
            <form action={makeSearchLink({ page: 1 })} method="get">
                <input className="text-black" type="search" placeholder="Pesquisar..." name="name" defaultValue={name}/>
                <button type="submit">Pesquisar</button>
            </form>
        <div className="container mt-8">
            <h1 className="text-2xl font-bold"> Lista de Produtos</h1>
            <Suspense fallback={<Loading/>}>
                <ProductsList name={name} page={page}/>
            </Suspense>
            
        </div>
        </div>
    )
}

export default ProductsListPage;